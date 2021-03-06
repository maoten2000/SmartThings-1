/*
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *	Author: Andy - TheHundredthIdiot
 *	Date:	February 2016
 *
 *	References:
 *
 *		https://community.smartthings.com/t/momentary-vitrual-switches-normally-on-double-pole/29174
 *
 */
 
metadata {
	definition (name: "My Simulated Momentary Alarm", namespace: "TheHundredthIdiot", author: "Andy") {
		capability "Actuator"
		capability "Switch"
		capability "Momentary"
        capability "Alarm"
	}

	simulator {
	}

	tiles {
		standardTile("switch", "device.switch", width: 3, height: 2, canChangeIcon: true) {
			state "on", label: 'Push', action: "momentary.push", icon: "st.Home.home30", backgroundColor: "#53a7c0", nextState: "off"
			state "off", label: 'Push', action: "momentary.push", icon: "st.Home.home30", backgroundColor: "#ffffff"
		}
		main "switch"
		details "switch"
	}
}

def parse(String description) {
}

def push() {
	sendEvent(name: "switch", value: "on", isStateChange: true, display: false)
	sendEvent(name: "momentary", value: "pushed", isStateChange: true)
	sendEvent(name: "switch", value: "off", isStateChange: true, display: false)
}

def strobe() {
	on()
}

def siren() {
	on()
}

def both() {
	on()
}

def on() {
	push()
}

def off() {
	push()
}

