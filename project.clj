(defproject baboon "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-ring "0.12.2"]]
  :ring {:handler baboon.core/handler}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [liberator "0.15.2"]
                 [compojure "1.6.0"]
                 [org.clojure/tools.nrepl "0.2.13"]
                 [ring/ring-core "1.6.3"]
                 [korma "0.4.3"]
                 [log4j "1.2.15" :exclusions [javax.mail/mail
                                              javax.jms/jms
                                              com.sun.jdmk/jmxtools
                                              com.sun.jmx/jmxri]]
                 ;; https://mvnrepository.com/artifact/mysql/mysql-connector-java
                 [mysql/mysql-connector-java "8.0.13"]

                 ]
  )
