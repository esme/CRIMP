# Comprehensive Realtime Index of Monkeys' Points (CRIMP)
###A realtime ranking system for [bouldering](http://http://en.wikipedia.org/wiki/Bouldering) competitions
Developed by [DongWei](https://github.com/leedongwei) and [Weizhi](https://github.com/ecc-weizhi) for [NUS - Black Diamond Boulderactive 2014](http://boulderactive.nusclimb.com).

## System Components
###admin
Admin interface with CRUD functions to competitors, rounds, routes and competition data. Mainly used to review scores at the end of the round and confirm accuracy of data.

###client
Web app for spectators.

###judge
Android/web app for judges to input scores. It uses QR code to identify climbers.

###paper
Generator for physical scoresheets with unique QR codes for every climber.

###server
node.js+express server to take in scores, store into a postgres database and push them to spectators