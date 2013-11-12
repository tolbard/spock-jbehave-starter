Scenario: Report overall suburb alarm status
Given we are monitoring the suburb of <suburb>
When the houses report the status values of <house_status_values>
Then the overall value should be <suburb_status>
Examples:
| suburb     | house_status_values           | suburb_status |
| Balmain    | GREEN, GREEN, GREEN  		 | GREEN		 |
| Parramatta | GREEN, GREEN, YELLOW 		 | YELLOW		 |
| Hornsby    | GREEN, RED, YELLOW   		 | RED  		 |
| Liverpool  | GREEN, RED, YELLOW, ORANGE    | ORANGE  		 |


Scenario: Display a suburb dashboard
When we are monitoring the following suburbs:
| suburb     | house_status_values           |
| Balmain    | GREEN, GREEN, GREEN  		 |
| Parramatta | GREEN, GREEN, YELLOW 		 |
| Hornsby    | GREEN, RED, YELLOW   		 |
| Liverpool  | GREEN, RED, YELLOW, ORANGE    |
Then the suburb dashboard should display:
| suburb     | status | alerts | police | fire  |
| Balmain    | GREEN  | 0      | false  | false |
| Parramatta | YELLOW | 1      | false  | false |
| Hornsby    | RED    | 2      | true   | false |
| Liverpool  | ORANGE | 3      | true   | true  |




