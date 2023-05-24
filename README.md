Coverage: 79.5%
# IMS-Project

This project includes an inventory management system with CRUD functionality for customers, items and orders. The user interacts with the application from the command line interface (CLI).

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

Java SE Development kit is required, and can be found here:
https://www.oracle.com/java/technologies/downloads/
MySQL Community including MySQL Workbench:
https://dev.mysql.com/downloads/windows/installer/8.0.html
Gitbash for terminal access:
https://git-scm.com/downloads
Apache Maven for testing:
https://maven.apache.org/download.cgi

With Maven you will need two dependencies: JUnit
Mockito

### Installing

A step by step series of examples that tell you how to get a development env running

``
STEP01:
Vist Clone the repository using gitBash to your local computer in a safe location.
``
``
STEP02:
In IMS-Project\src\main\resources you must do the following steps
 - Open the sql-schema.sql in your MySQL WorkBench
 - Open the sql-data.sql in your MySQL Workbench
 - Run both files in MySQL 
 - Now you need to change the db.properties to have your local access (Shown below)

db.url=jdbc:mysql://localhost:3306/ims
db.user="username here" - (if forgotten attempt = root)
db.password="password here" - (if forgotten attempt = root)
``
``
STEP03:
Now step 2 is complete open the location where you downloaded the repository folder to.
 - Right click in the main "IMS-Project" folder and launch "Git Bash Here".
 - Type mvn clean.
 - Type mvn package.
 - Close GitBash terminal.
 - Move to the "target" folder.
 - Right click in the folder and launch "Git Bash Here".
 - Type "java -jar ims-0.0.1-jar-with-dependencies.jar".
``
## Build Example
Below is an example build of item domain.



## Running the tests

As the Prerequisites have been complete access the testing feature through the src/test/java.
* Select folder with right click.
* Select "Coverage As"
* Select "JUnit test" This will run all the tests and generate a coverage table indicating how much of the code has been covered in the testing and what percentage passed/failed/errored.

### Unit Tests 

Unit testing is a form of testing that involves testing smaller isolated portions of code that may be utilised logically by setting up conditions to use before testing.
In thisÊproject, unit testing was employed for the getter/setter/toString methods of each class (customer, orders, items)
```
@Test
	public void testToString() {
		item = new Item(id, itemName, price);
		assertEquals(("item ID:" + item.getItemId() + " item name:" + item.getItemName() + " item price:" + item.getItemPrice()), item.toString());
	}

```

### Integration Tests 
Integration testing involves combining several tests on components of a programme to check if they operate logically together.
Each controller is subjected to integration testing in this case (ItemController, OrdersController and CustomerController)
```
@Test
	public void testCreate() {
		final String itemName = "cardigan";
		final double price = (double)80.99;
		final Item item = new Item(itemName, price);

		Mockito.when(utils.getString()).thenReturn(itemName);
		Mockito.when(utils.getDouble()).thenReturn(price);
		Mockito.when(DAO.create(item)).thenReturn(item);

		assertEquals(item, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(DAO, Mockito.times(1)).create(item);

	}
```



## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

GitHubÊfor versioning.

## Authors

* **Ibraheem Latif** - *Final work* - https://github.com/ibraheem-latif


* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*



