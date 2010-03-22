(ns org.jclouds.aws-test
  (:use [clojure.test]
        [org.jclouds.blobstore-test :only [clean-containers
                                           corruption-hunt]]))

;; Edit core/src/test/resources/blobstore-credentials.properties
;; to provide S3 credentials in order to test this against live S3:
(use-fixtures :each clean-containers)

(deftest aws-corruption-hunt
  (corruption-hunt))
