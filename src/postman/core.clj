(ns postman.core)

(defn hi [adapter codec]
  (let [connected false
        disconnected true
        id (atom "0")
        state (atom disconnected)
        callbacks (atom {})
        send (fn [payloadType payload callback]
               (if (= @state disconnected)
                 (callback disconnected)
                 (let [correlationIdentifier (swap! id (fn [s] (str (inc (int s)))))
                       message (.encode codec payloadType payload correlationIdentifier)]
                   (swap! callbacks assoc correlationIdentifier callback)
                   (.send adapter message))))
        recive (fn [payloadType payload correlationIdentifier]
                 (let [callback (get @callbacks correlationIdentifier)]
                   (when-not (nil? callback)
                     (callback payload))))]
    (.onOpen adapter #(reset! state connected))
    (.onEnd adapter #(reset! state disconnected))
    (.decode codec recive)
    send))
