

### Project 2 Proposal ###

## Find a Friend ##
##### Web-web-application
#####

__Team Composition:__<br>
Diaz Agasatya, Dmytro Marych, Yushu, Kazu

November 12th, 2017

---

#### Table of Contents ####

* 1 Project Overview 
  * 1.1 Abstract…………………………………….………………………Pg 3
  * 1.2 Target Customer……………….…………………………………Pg 4
  * 1.3 Search Words……………….……………………………………Pg 4
  * 1.4 Scope and Objectives….…………………………………………Pg 4, 5
* 2 Team and Constraints
  * 2.1 Team Profile…….……………………………………………….…Pg 6
  * 2.2 Challenges……….……………………………………………….Pg 7
  * 2.3 Assumptions and Constraints………………………………....Pg 7
* 3 Deliverables and Milestones
 * 3.1 Project Deliverables……………………………………………..Pg 8
 * 3.2 Schedule and Budget Summary…..…………………………..Pg 9


---

## 1.0	Project Overview
### 1.1 Abstract

##### “ Manage your schedules to open up further networks…”

Find a Friend functions as a finding a friend match web-application, that matches with free-time, hobby, & majors. Our goal is for the the web-application
to hold about 50,000+ accounts, with a running time of O(LogN) in the matching algorithm. With a minimum of 15,000+ student informations to find a match for the user.

"An easy and manageable friend finder for user"

* Find a Friend offers users to experience easy friend finder web-application. This web-application
 will simply ask your free-time schedule, hobbies, major and other informations like full name, email
 etc and the Algorithm will find a match in a matter of seconds. The user will be able to see "potential
 friends" that has the same/similar free-time schedule as the user. Once the user sign up and received a username, 
 the user can simply log in and click the "Find a Friend" button that will initiate the matching algorithm that will 
 show the list of user's that is considered a match. The conditions that considered as a "match" will be depending on
 the free-time schedule itself, hobby and major.      

* Background : one of the our team member has been struggling to find a friend that has the same free time schedule between classes, 
or just simply looking for a friend that has the similar interest. This web-application will bridge the gap for students in Foothill College 
that is new to the campus, and wants to be socially active with other students that may be a suitable or potential friend for them.


* The value of the system is to offer new connections and network of people whose interests are similar to one, 
to provide an easy time-scheduling experience with the shared calendar with other users and to gives an encouragement to meet new people. 
Find a Friend has high versatility in further functionalities. For example, if we establish a GPS location service or a geographic information, 
one happens to hangout with his / her friends after scheduling their plans with Find a Friend and adding a place to meet to Find a Friend, 
then we can add a function that suggests what they like to do such as showing restaurants around where they are, 
fun places to visit and popular activities based on their interests.


* The final product will be used by many people regardless of age or sex daily. In the future development,
we would launch a smartphone web-application of Find a Friend in both Android and IOS  to increase portability.


### 1.2.	Target Customer

Students

We aim for many people regardless of age or sex who has internet access from their device.

Intended user group(s):
*	Both client and users would be whoever sign up for the system:
*    We would be the host	


### 1.3.	Search Words 
Match, Matching Algorithm, Friend, FriendFinder, FindaFriend, Scheduler, Calendar, Auto, Easy, Social Media, Web Connect, Shared ….

### 1.4.	Scope and Objectives
* Objective / goal

Our ultimate objective is to create a system that helps people to connect with other people that has the similar interest,
 which most importantly the same free-time schedule (time gap between classes) for students in campus. 

* Scope

Here’s a brief scope of the project:
The system consists of several layers. For the user end, we would use Java Servlet, JSP, and Tomcat as our main server and data manipulation.
This will ultimately return a dynamic html file for the user to manipulate and interact with.
User would need to be online in order to use this web-application to reach the server. More specifically, the program will read a file of 
student information, thus the only dependent variable needed is user's free-time schedule, hobbies and major in order for the matching process begins.


### Front  End

We will be using JSP as our html file front-end, Java Servlet for our data manipulation, and Tomcat as our web container (http server).

The first layer of the system is log- in screen that takes ID and password to sign-in. If a user does not have an account 
with us, then ask them to sign up for the first time. (we utilize a database to complete this phase )

User must first sign-up in order to use this web-application, upon initiation the home page will feature log-in and sign-up option, Upon Sign up page:
*  User will enter full name,

* Password for logging-in

* Gender

* Major

* eMail

* Hobbies

* Free-time schedule with currently a format of (HH:MM:ss - HH:mm:ss)

Once a user successfully logged-in, we show users the main user pape that display the following features: 

* User's full name

* User's Major

* User's eMail

* User's Hobbies

* "Find a Friend" button that will run the matching algorithm for the user

Once a user clicked the "Find a Friend" button the user will see the list of potential friends that has the same/similar
 free-time, interest, and hobbies (sorted highest at the top with the most matching points)


### Back End

The back end has several classes to maximize the advantage of object-oriented programming. (*implementation might change as we code)

ConsoleApp/FindAFriend/

* DatabaseStack class: One object of this class will represent a database of users, 
this will contain the ArrayList<User> database object that holds 15,000+ users build inside the program.

* MatchingAlgorithm class: One object of this class represents a partitioned database based upon user's highest ranking free time, 
and also a list of potential friends that match user's schedule, hobby, and major.

* SortingDatabase class: This class be a generic function class for sorting purposes.

* User class: One object of this class represents a single user containing fullname, email, hobby, major and LinkedList of their free time schedule.

* TestingDatabase class: This class will test the database. 

* TestingAlgorithm class: This class will do a black-box test of the algorithm. 

#### Web - Application ####

* JSP will be our main design / front-end html file that will be return to the client during the process, a JSP file will be
our main response back from the server.

* Java Servlet will be our main java classes that will manipulate the data input given from user, and this will also include the 
data manipulation of database and also the matching algorithm that will be conducted through a specific servlet.

* Tomcat will be our web container/servlet container that will have a deployment descriptor web.xml file that will be a helper file
to act per user's/clients requests. This xml file will be calling a specific servlet class that will ultimately manipulate data and return
back a response object as a html file that the user will see.

## 2.0	Team and Constraints

### 2.1.	Team profile
* Diaz … Java - Algorithm, C++, Python - Machine Learning & Neural Networks

* Yushu … Java, HTML & CSS basic, Development of web web-application

* Dmytro … Java, JavaFX, Python

* Kazu … Java, Python, C++, ruby, Ruby on Rails assembly basic


### 2.1.	Challenges
* Getting student information such as email address or class schedule.

* Web-application will be a challenge for the four of us since we don't have any background in regards to web developement.

* Learning Java Servlet, JSP, and Tomcat as we go will be challenging for us in terms of time constraint and expectations for every week.

* This will be an exciting challenge for the four of us, since we will refine Find a Friend to the next level!

* Memory of holding hundreds of student accounts.

* Designing front end (easy & simple to use, looks cool to attract customers).

* Learning HTTP servers including: Tomcat, Java Servlet, and JSP.

* Creating back end to work as a “Find a Friend” software (Java).

### 2.2.	Assumptions and Constraints

* Non-Technical Constraints:
  * We have only few weeks
  * Budget?
  * Working well as a team
* Techinical Constraints:
  * Login.Database to hold student info
  * Designing user interface

---

## 3.0	Deliverables and Milestones

### 3.1.	Project Deliverables 

Our product provides customers with an easy and accessible way to find a potential friend for the user. 

We deliver:
* Connection for students
* Network for similar interests
* Encouraging to meet new people


### 3.2.	Schedule and Budget Summary
Our team will work on creating an easier and better way for students to arrange their meetings based on their busyness.

Milestones for this project:

* Project Proposal - written paper about the project, team members, goals, challenges etc.
* Proposal Presentation - the presentation of the project.
* Building the http server environment - Creating the HTTP environment using Tomcat, Java Servlet and JSP.
* Implementing Tomcat as our web container
* JSP files to show different html files for different interactions from clients. This will include Deployment Descriptor class
* Start building java servlet classes that will manipulate data inputs.
* 1st User Interface - Log-in and Sign-up page
* 2nd User Interface - Matching Algorithm works and shows all of potential friends
* Full scope of cleaning code and debugging - tests of the full program; debugging of the program
* Testing to public / Class - delivery of the project to some members of the class; tests in class.
* Recap;
* Demonstration and delivery - presentation of the program to the whole class and the professor.



#### Milestones

| Item                       | Date             |
| :--------------------------|:-----------------|
| Project Proposal           | November 12, 2017  |
| Proposal Presentation      | November 9, 2017  |
| Building the http server environment   | November 16, 2017 |
| Implementing Tomcat as our web container    | November 21, 2017 |
| JSP files to show different html files for different interactions from clients.                     | November 23, 2017 |
| Start building java servlet classes that will manipulate data inputs.                  | November 27, 2017 |
| 1st User Interface                        | November 28, 2017 |
| 2nd User Interface | November 30, 2017 |
| Full scope of cleaning code and debugging             | Dec 3, 2017 |
| Testing to public / Class               | Dec 5, 2017 |
| Recap                  | Dec 7, 2017 |
| Demonstration and delivery           | Dec 14, 2017 |
