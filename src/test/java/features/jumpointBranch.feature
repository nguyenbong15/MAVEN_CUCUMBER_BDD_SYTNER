@jumppointbranch
Feature: JumpPoint To Branch

@audi
Scenario Outline: open about us link menu item
	Given I open home page 
	When I click to accept cooking alert
	And I click to hide form
	And I click to "<nameBranch>" branch
	Then verify link "<linkPage>" display
	And verify icon branch "<namebranchVerify>"  display
	And I back to Home Page
    Examples:
      | nameBranch             | linkPage                                             | namebranchVerify             | 
      | Alpina                 | https://www.sytner.co.uk/bmw/alpina-range/           | /bmw/                        | 
      | AMG                    | https://www.sytner.co.uk/mercedes-benz/new-cars/amg/ | /mercedes-benz/ | 
      | Aston Martin           | https://www.sytner.co.uk/aston-martin/               | /aston-martin/               | 
      | Audi                   | https://www.sytner.co.uk/audi/                       | /audi/                       | 
      | Bentley                | https://www.sytner.co.uk/bentley/                    | /bentley/                    | 
      | BMW                    | https://www.sytner.co.uk/bmw/                        | /bmw/                        | 
      | Bugatti                | https://www.sytner.co.uk/bugatti/                    | /bugatti/                    | 
      | Ferrari                | https://www.sytner.co.uk/ferrari/                    | /ferrari/                    | 
      | Jaguar                 | https://www.sytner.co.uk/jaguar/                     | /jaguar/                     | 
      | Land Rover             | https://www.sytner.co.uk/landrover/                  | /landrover/                  | 
      | Lamborghini            | https://www.sytner.co.uk/lamborghini/                | /lamborghini/                | 
      | Maserati               | https://www.sytner.co.uk/maserati/                   | /maserati/                   | 
      | McLaren                | https://www.sytner.co.uk/mclaren/                    | /mclaren/                    | 
      | Mercedes-Benz          | https://www.sytner.co.uk/mercedes-benz/              | /mercedes-benz/              | 
      | MINI                   | https://www.sytner.co.uk/mini/                       | /mini/                       | 
      | Porsche                | https://www.sytner.co.uk/porsche/                    | /porsche/                    | 
      | Rolls-Royce            | https://www.sytner.co.uk/rolls-royce/                | /rolls-royce/                | 
      | SEAT                   | https://www.sytner.co.uk/seat/                       | /seat/                       | 
      | ŠKODA                  | https://www.sytner.co.uk/skoda/                      | /skoda/                      | 
      | smart                  | https://www.sytner.co.uk/smart/                      |  /smart/                     | 
      | Volkswagen Cars        | https://www.sytner.co.uk/volkswagen/                 | /volkswagencars/             | 
      | Volkswagen Commercials | https://www.sytner.co.uk/volkswagencommercials/      |    /volkswagencommercials/   | 
      | Volvo                  | https://www.sytner.co.uk/volvo/                      |  /volvo/                     | 
      | Sytner Select          | https://www.sytner.co.uk/sytnerselect/               |   /sytnerselect/             | 
      | Carshop                | https://www.sytner.co.uk/site/carshop/               |    /carshop/                 | 
  
	
	
	
	
	
