; Basic DemoRobot taken from https://robowiki.net/wiki/Other_JVM_Languages
(ns clobot.DemoRobot
  (:gen-class :extends robocode.AdvancedRobot))

; Private declarations
(declare normalise)

(defn -run [robot]
  (doto robot
    (.setAdjustRadarForGunTurn true)
    (.setAdjustRadarForRobotTurn true)
    (.setAdjustGunForRobotTurn true))
  (loop [r robot]
    (.setAhead r 30)
    (.setTurnRightRadians r 1)
    (when (= 0 (.getRadarTurnRemainingRadians r))
      (.setTurnRadarRightRadians r 4))
    (.execute r)
    (recur r)))

(defn -onScannedRobot [robot event]
  (.setTurnGunRightRadians
   robot (normalise (- (+ (.getBearingRadians event) (.getHeadingRadians robot))
		       (.getGunHeadingRadians robot))))

  (when (< (Math/abs (normalise (.getGunTurnRemainingRadians robot)))
	   robocode.Rules/GUN_TURN_RATE)
    (.setFire robot 2))
  (.setTurnRadarRightRadians
   robot
   (* (normalise (- (+ (.getBearingRadians event) (.getHeadingRadians robot))
		    (.getRadarHeadingRadians robot)))
      1.9)))

(defn- normalise [angle]
  (robocode.util.Utils/normalRelativeAngle angle))
