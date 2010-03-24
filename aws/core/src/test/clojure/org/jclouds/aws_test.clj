(ns org.jclouds.aws-test
  (:use [clojure.test]
        [org.jclouds.blobstore-test :only [blobstore-fixture
                                           properties
                                           corruption-hunt]]))

;; Edit core/src/test/resources/blobstore-credentials.properties
;; to provide S3 credentials in order to test this against live S3:
(use-fixtures :each blobstore-fixture)

(deftest aws-corruption-hunt
  (when (= "s3" (properties "service"))
    (corruption-hunt)))
