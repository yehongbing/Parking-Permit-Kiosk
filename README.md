#Parking Permit Kiosk
> EECS 3461 Assignment #1
> Members: Shayan Rafizadeh, Hongbing Ye, Li Yin

> hongbing, 212678405, Ye, Hongbing
> srafizad, 213145966, Rafizadeh, sHAYAN
> yinl1, 211608973, Yin, Li

## Introduction:
This project models a parking kiosk touchscreen interface found in most parking terminals. The interface prompts user for login information and produces a parking permit based on input information provided by the user. The interface implements javax.swing elements and design to produce an attractive and functional interface that is easy-to-use and understand.

## Purpose:
The purpose of this assignment is to apply and use knowledge regarding java's swing package to create a GUI that represents a parking kiosk terminal. It will use classes and methods learned in class, including but not limited to: JFrame and components, event and action listeners, and proper input and output methods. In addition, this project will teach us the basic concepts of good design and layout, where the user experience emphasized through easy to understand and clear elements and commands.

## Design:
Prior to writing the source code, the group came together to discuss general design of the interface. During the first discussion, the group decided to implement a total of 5 super-panels: welcome screen, login screen, vehicle information, insurance information, and user information. In addition, an on-screen keyboard and numberpad would be required to take in user input in a touchscreen interface. With this knowledge, the group proceeded to design and create the required super panels. Preliminary designs are simple and bare-bone. Simple textfields and labels prompt for the required user input and keyboards/numberpads act as input components for each panel.

During the second discussion, the group decided to add 2 additional panels to the interface, incorporating a panel for permit period in the date panel and a confirmation screen. The date panel will use combo boxes to specify begin and end dates of the permit. Each date will have 3 combo boxes, representing the Month, Day, and Year. In addition, the group decided that a method to calculate the total billed amount would be necessary on this panel for proper user feedback, allowing users to change the period as required to fit their respective budgets. The confirmation screen will display all user inputs and allows for user to edit the proper field if needed. Editing fields will take users back to the respective panels to allow for editing in the corresponding panel.

Final discussion regarding design involved the overall aesthetic elements of the interface. This included the overall look and layout. At first, the group decided it was best to incorporate bootstrap CSS for styling. However, after much experimentation and backtracking, it was determined that swing Look-And-Feel would be the most appropriate for the interface. In addition, we felt that a simple LAF design would be most appropriate to provide users with the best overall experience. This would also be best in representing good design, whereas, a very complicated LAF may make the interface appear too cluttered and hard to understand.

## Methods:
Since the assignment is to test our overall understanding of of the Oracle 'swing' package, we used JFrame as the basic foundation for all of our other JComponents. Each 'page' of the interface incorporates the idea of a 'superpanel' which envelopes other JPanels and JComponents. Elements such as JButtons, JTextfields, and JLabels are added to its own respective panels before being added to the superpanels. This provided us with flexible in terms of design and placement of the elements, allowing us to play around with borders and size. 

Different forms of layouts were also used for different panels. The group felt that this was necessary to reflect the different design of each panel and their differences. While GridLayout was most commonly used, we also used Flow- and BorderLayouts to accomodate for design differences between each superpanel. In addition to improving overall design, this also furthered our understanding of Java's different layout managers and their respective uses.

For styling, we used Synthetica's Simple 2D Look And Feel. While simplistic, the look also reflects the look of an actual parking terminal interface with bright and clear to understand elements.

## Discussion and Meetings:
Overall group discussions were seperated into 3 stages. The first stage was the preliminary design and developement stage, which included 2 meetings as well as Skype conversations. The second stage was the post-design stage, which included 3 meetings in addition to Skype conversations. The final stage was the finalizing stage, which included 1 meeting to finalize the project.

## Preliminary Design
### Meeting 1 (September 15, 2015, 4:00 pm):
General discussion about basic design and project foundations. Layout and input ideas were also discussed at this time.
### Meeting 2 (September 22, 2015, 4:00 pm):
Second discussion regarding design. Here, we decided it was necessary to add 2 more panels to reflect the information we required from the user. Design and layout for these 2 additional panels were also discussed. 
Skype Conversations (varying time):
These conversations mainly reflected any problems or issues we had while working on the basic design of the interface. In addition, new ideas were also discussed and debated to determine what was necessary to reflect a parking terminal.

## Post-Design
### Meeting 1 (September 29, 2015, 4:00 pm):
By this time, the design and foundation for the interface has been completed. This meeting was to make sure that all members understood the design and coding behind the interface.
### Meeting 2 (October 1, 2015, 4:00 pm):
This meeting discussed the styling required for the interface as well as verification methods for buttons and textfields. During this meeting, we decided to scrap the idea of using bootstrap and incorporate Look And Feel styling.
### Meeting 3 (October 6, 2015, 4:00 pm):
Urgent meeting to discuss changes to certain design elements, including keyboard layout and the information displayed on confirmation page. Last meeting before finalization of code elements. 
Skype Conversations (Varing time):
Conversations involving slight changes to certain design elements and as well as questions regarding overall thoughts.

## Finalizing
### Meeting 1 (October 22, 2015, 7:00 pm):
Finalized code and overall design and style. Prepared project for submission. Mostly aesthetic changes discussed here. Final meeting for assignment 1.
