To execute the project please download the FINZYTEST project please find below the steps:
Download the FINZYTEST project and import the same in Eclipse (this project will be downloaded as a MAVEN Project as it was created as is)
TESTNG, Selenium JARS would bee downlaoded from the POM.XML itself once the project is downlaoded and POM.XML is saved.


FEW Challenges faced/words on the flow and how the design took place
 First challenge was to make sure that the no of suggestions weren't hardcoded and a dynamic xpath was written to identify them
 I had written a dynamic xpath to identtify the suggestions provided as a keyword in the google search (as the DOM of gooogle search is very dynamic). Next to accept more than 4 keywords a test driven fframework was written using an excem file which was made to read the data using @DataProvider annotation in TestNG
 Another challenge was to make the Excel file read containing the test datas
For running the test case in multiple browser one way was that a datadriven file was created in TESTNG to make sure that depending on the parameter passed the browser would be launched and test cases would be executed.
The second method followed for parallel execution was creating a Testng.xml file and adding keywords like parallel and thread-count, to excute test cases in different browsers (Cross browser testing), keyword added was <paramater ="browser" value ="name of the browser">
According to the paramter available and being passed in the test case , the execution on the browser would take place.
Was a challenging task and i got to learn a lot of stuff from it.
