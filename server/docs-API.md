#For judge

##GET ('/judge/get/:round')
:round [:round expects 3 characters: NMQ/NWF]

	response (header: 200):
	{
		"climbers": [
			{
				"c_id":"",
				"c_name":""
			}
		]
	}


##GET ('/judge/get/:c_id/:r_id')

:c_id [climber_id expect 5 characters: NW001/NM001]
	first 2 char to be category, last 3 char to be climber number
:r_id [route_id expect 5 characters: NWQ01/NMF01]
	first 3 char to be round name, last 2 char to be route number
	**The first 2 character of c_id and r_id must match**

	response (header: 200):
	{
		"c_name" : "climber_name",
		"c_score" : "magic_string"
	}



##POST ('/judge/set')
	body:
	{
		"j_name" : "judge's name"
		"auth_code" : "",
		"r_id" : "route_id",
		"c_id" : "climber_id",
		"c_score" : "magic_string"
	}

	response (header: 200 / 401 Unauthorized):
	{}




#For client

##GET ('/client/get/:round')
:round [round expects 3 characters: NWQ NMF]

	response (header: 200):
	{
		"climbers": [
			{
				"c_id":
				"tops":
				"t_att":
				"bonus":
				"b_att":
			}
		]
	}