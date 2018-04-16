# Warframe Tracker app

## Description

	App that notifies a user of events and invasions in warframe using the
	warframe worldstate API (http://content.ps4.warframe.com/dynamic/worldState.php)
	App will allow users to choose to be warned for specific event rewards
	unlike regular notifier apps in order to only be warned for whatever it is
	they're looking for. Will probably contain a reasonable library of possible
	rewards and if possible will implement their price as extrapolated from
	the nexus-stats and/or warframe.market

## Goals (^important)
	* Be notified for specif events rewards (recieve notification for every
	invasion that can give a mutalist nav coord / mod / nitain exract / etc)
	
	* Create an offline libraby for possible mods or drops (may require
	internet at first to fetch data, kept afterwards)
	
	* Add value for tradable items by fetching from nexus-stats and/or .market
	
	* Allow to switch from PS4 alerts to PC alerts
	
	* *Lead* : Allow to quickly sell items on the market
	
	* *Lead* : Keep inventory of Prime parts belonging to an account
	
	* *Lead* : Keep posted on extractor status

## APIs
	* Warframe docs:	https://docs.warframestat.us/#tag/warframe
	* Nexus-stats: 		https://nexus-stats.com/api
	* World state: 		http://content.ps4.warframe.com/dynamic/worldState.php
	* Database: 		https://api.warframestat.us/weapons
	
**Mockup available in docs folder**