(defproject postman "0.1.1"
  :description "Match respond to request"
  :url "https://github.com/spirinvladimir/postman"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :profiles {:dev {:plugins [[com.jakemccrary/lein-test-refresh "0.19.0"]]}}
  :test-refresh {



                 ;; If this is specified then only tests in namespaces
                 ;; that were just reloaded by tools.namespace
                 ;; (namespaces where a change was detected in it or a
                 ;; dependent namespace) are run. This can also be
                 ;; passed as a command line option: lein test-refresh :changes-only.
                 :changes-only true


                 ;; specifiy a custom clojure.test report method
                 ;; Specify the namespace and multimethod that will handle reporting
                 ;; from test-refresh.  The namespace must be available to the project dependencies.
                 ;; Defaults to no custom reporter
                 ;;:report  myreport.namespace/my-report

                 ;; If set to a truthy value, then lein test-refresh
                 ;; will only run your tests once. Also supported as a
                 ;; command line option. Reasoning for feature can be
                 ;; found in PR:
                 ;; https://github.com/jakemcc/lein-test-refresh/pull/48
                 :run-once true

                 ;; If given, watch for changes only in the given
                 ;; folders. By default, watches for changes on entire
                 ;; classpath.
                 :watch-dirs ["src" "test"]

                 ;; If given, only refresh code in the given
                 ;; directories. By default every directory on the
                 ;; classpath is refreshed. Value is passed through to clojure.tools.namespace.repl/set-refresh-dirs
                 ;; https://github.com/clojure/tools.namespace/blob/f3f5b29689c2bda53b4977cf97f5588f82c9bd00/src/main/clojure/clojure/tools/namespace/repl.clj#L164
                 :refresh-dirs ["src" "test"]})
