(defproject com.brunobonacci/safely "0.7.0-alpha3"
  :description "Safely is a Clojure's circuit-breaker library for handling retries in an elegant declarative way."
  :url "https://github.com/BrunoBonacci/safely"

  :license {:name "Apache License 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}

  :scm {:name "git" :url "https://github.com/BrunoBonacci/safely"}

  :dependencies [[org.clojure/clojure "1.10.3"]
                 [org.clojure/core.match "1.0.0"]
                 [defun "0.3.1"]
                 [org.clojure/tools.logging "1.2.3"]
                 [com.brunobonacci/mulog "0.8.1"]
                 [amalloy/ring-buffer "1.3.1"]]

  :global-vars {*warn-on-reflection* true}

  :jvm-opts ["-server"]

  :profiles {:dev {:resource-paths ["dev-resources"]
                   :dependencies [[org.clojure/test.check "1.1.1"]
                                  [midje "1.10.5"]
                                  [org.slf4j/slf4j-log4j12 "1.7.32"]
                                  [com.brunobonacci/mulog-zipkin "0.8.1"]]
                   :plugins [[lein-midje "3.2.2"]]}

             :clj18  {:dependencies [[org.clojure/clojure "1.8.0"]]}
             :clj19  {:dependencies [[org.clojure/clojure "1.9.0"]]}
             :clj110 {:dependencies [[org.clojure/clojure "1.10.1"]]}
             }

  :aliases {"test" ["do" "clean," "midje"]
            "build-all"  ["with-profile" "+clj18:+clj19:+clj110" "do" "clean," "check," "midje," "jar"]}
  )
