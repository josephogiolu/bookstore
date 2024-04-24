# Bookstore App Design and Implementation 

Application Design Documentation 

This is avaialable of Doc 

    https://docs.google.com/document/d/1L5DpQd3IyUciSw4UDVrSM4PvTPOh7r30M7_cKiz4IuU/edit

    

The Application was build with spring boot and Postgre DB


Prerequisite

1 Kindly ensure jdk 21 is installed

2 Ensure Docker is installed

3 We have the assumption you would be running it on linux or a mac ox


Installation 


1 Clone the repository 

       git clone https://github.com/josephogiolu/bookstore.git

2 CD to the root directory of the cloned project

    cd bookstore

3 Install docker on the environment if you don't have it installed 

4 The project has postgre bundled in docker container  
  run this command to start up the  db  
  
    docker-compose -f docker-compose-db.yml up -d
    

5 Run the command 

     chmod +x build.sh  
     
 These will make the build.sh file executable 

6 Run the command

       ./build.sh 
       
  This builds the app docker image

7 Run  the command

    docker-compose up -d 
   
This starts up the app on port 8282
  
8 Access the endpoints on swagger 

    http://localhost:8282/swagger-ui/index.html#/
  




