(ns baboon.core
  (:require [clojure.pprint :refer [pprint]]
            [clojure.data.json :refer [write-str]]
            [liberator.core :refer [resource defresource]]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.core :refer [defroutes ANY GET]]
            [korma.db :refer :all]
            [korma.core :refer :all]))

(defdb db (mysql {:db "baboon"
                  :user "root"
                  :password ""}))
(defentity korma)





(def counter (atom 0))
(defresource hello
  :available-media-types ["text/html"]
  :handle-ok "<h1>hello liberator!</h1>")
(defresource ctx
  :available-media-types ["text/html"]
  :handle-ok (fn [ctx]
               (str ctx)))

(defresource decision
  :uri-too-long? true
             ;:service-available?  false
  :available-media-types ["text/plain"]
  :handle-ok "serivce available . ok?")
(defresource db
  :available-media-types ["application/json"]
  :handle-ok (write-str (select korma)))
(defroutes app
  (ANY "/" [] (resource
               :available-media-types ["text/html"]
               :handle-ok (fn [ctx]
                            (swap! counter + 1)
                            (format "the counter is %d" @counter))))
  (GET "/hello" [] hello)
  (GET "/ctx" [] ctx)
  (GET "/decision" [] decision)
  (GET "/api/count" [] db))

(def handler
  (-> app
      wrap-params))



(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
