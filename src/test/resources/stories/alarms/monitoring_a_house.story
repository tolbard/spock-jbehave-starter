Scenario: Report overall alarm status for a house
Given I am monitoring a house with a set of alarms
When the alarms report <alarm_status_values>
Then the overall alarm status should be <overall_status>
Examples:
| alarm_status_values 		 | overall_status   | police | firebrigade |
| GREEN, GREEN, GREEN  		 | GREEN			| false  | false       |
| GREEN, GREEN, YELLOW 		 | YELLOW			| false  | false       |   
| GREEN, RED, YELLOW   		 | RED  			| false  | false       | 
| GREEN, RED, YELLOW, ORANGE | ORANGE  			| true   | true        |

Scenario: Notify the police or fire brigade
Given I am monitoring a house with a set of alarms
When the alarms report <alarm_status_values>
Then the police notification status should be <police>
And the Fire Brigade notification status should be <firebrigade>
Examples:
| alarm_status_values 	     | police | firebrigade |
| GREEN, GREEN, GREEN  		 | false  | false       |
| GREEN, GREEN, YELLOW 		 | false  | false       | 
| GREEN, RED, YELLOW   		 | true   | false       |
| GREEN, YELLOW, ORANGE      | false  | true        |
| GREEN, RED, ORANGE   		 | true   | true        |