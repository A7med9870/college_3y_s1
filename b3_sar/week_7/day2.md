consider the following relations which might form part of a database for a hairdressing salon

client(CNo,Name,Phone,FavouriteStylist)
Stylist(Sno,Name,Phone)
Treadtment(TreatmentName,Price,Duration)
Booking(Cno,Sno,Date,Time,TreatmentName)

indicate in each case all candidate keys, discussing any assumptions that you make. choose a primary key for each relation. identify any foreign keys

analyzing each relation for the hairdressing salon database to determine the candidate keys, primary keys, and foreign keys, along with the necessary assumptions:

### 1. **Client(CNo, Name, Phone, FavouriteStylist)**

- **Attributes**:
  - `CNo`: Client number, assumed to be a unique identifier for each client.
  - `Name`: The client's name, which may not be unique.
  - `Phone`: The client's phone number, which could be unique, but may not be if clients share phone numbers.
  - `FavouriteStylist`: Refers to a stylist, which is not unique as multiple clients can have the same favorite stylist.

- **Candidate Keys**:
  - `CNo`: Since this is likely a unique identifier, it is a candidate key.
  - `Phone`: Assuming that phone numbers are unique to each client, `Phone` could also be a candidate key. However, in some cases (e.g., family members), the same phone number might be shared.
  
  Given the possibility of shared phone numbers, we will assume `CNo` is the only reliable unique identifier.

- **Primary Key**: 
  - `CNo` (Client number) is chosen as the primary key because it is guaranteed to uniquely identify each client.

- **Foreign Keys**:
  - `FavouriteStylist`: This would refer to the `Sno` (Stylist number) in the `Stylist` relation. Thus, it is a foreign key referencing `Stylist(Sno)`.

---

### 2. **Stylist(SNo, Name, Phone)**

- **Attributes**:
  - `SNo`: Stylist number, assumed to be a unique identifier for each stylist.
  - `Name`: The stylist's name, which may not be unique.
  - `Phone`: The stylist's phone number, which could be unique but may not be if multiple stylists share a phone.

- **Candidate Keys**:
  - `SNo`: Stylist number is likely a unique identifier and is thus a candidate key.
  - `Phone`: If we assume phone numbers are unique to each stylist, `Phone` could also be a candidate key. However, the possibility of shared phone numbers reduces its reliability.

- **Primary Key**:
  - `SNo` (Stylist number) is chosen as the primary key because it uniquely identifies each stylist.

- **Foreign Keys**:
  - None in this relation, as it is independent of the other relations.

---

### 3. **Treatment(TreatmentName, Price, Duration)**

- **Attributes**:
  - `TreatmentName`: The name of the treatment, assumed to be unique for different types of treatments.
  - `Price`: The price of the treatment.
  - `Duration`: The duration of the treatment.

- **Candidate Keys**:
  - `TreatmentName`: It is likely that treatment names are unique and thus would be a candidate key.

- **Primary Key**:
  - `TreatmentName` is chosen as the primary key because it uniquely identifies each type of treatment.

- **Foreign Keys**:
  - None, as this table is independent and does not refer to other relations.

---

### 4. **Booking(CNo, Sno, Date, Time, TreatmentName)**

- **Attributes**:
  - `CNo`: Client number, which references a client from the `Client` relation.
  - `Sno`: Stylist number, which references a stylist from the `Stylist` relation.
  - `Date`: The date of the booking.
  - `Time`: The time of the booking.
  - `TreatmentName`: The treatment booked, which references a treatment from the `Treatment` relation.

- **Candidate Keys**:
  - A combination of `CNo`, `Sno`, `Date`, `Time` can uniquely identify a specific booking. This is because a client cannot have two bookings with the same stylist at the same date and time.
  
  Since it is possible that the same client might book multiple different treatments at the same time or different clients may book different treatments with the same stylist at the same time, we assume that `CNo`, `Sno`, `Date`, and `Time` together make up the unique identifier for a booking.

- **Primary Key**:
  - The composite key `(CNo, Sno, Date, Time)` is chosen as the primary key because it uniquely identifies a booking.

- **Foreign Keys**:
  - `CNo`: Foreign key referencing `Client(CNo)`.
  - `Sno`: Foreign key referencing `Stylist(Sno)`.
  - `TreatmentName`: Foreign key referencing `Treatment(TreatmentName)`.

---

### Summary of Keys

| Relation      | Candidate Keys           | Primary Key              | Foreign Keys                                                                                |
| ------------- | ------------------------ | ------------------------ | ------------------------------------------------------------------------------------------- |
| **Client**    | `CNo`, `Phone`           | `CNo`                    | `FavouriteStylist` → `Stylist(Sno)`                                                         |
| **Stylist**   | `SNo`, `Phone`           | `SNo`                    | None                                                                                        |
| **Treatment** | `TreatmentName`          | `TreatmentName`          | None                                                                                        |
| **Booking**   | `(CNo, Sno, Date, Time)` | `(CNo, Sno, Date, Time)` | `CNo` → `Client(CNo)`, `Sno` → `Stylist(Sno)`, `TreatmentName` → `Treatment(TreatmentName)` |

These are the candidate keys, primary keys, and foreign keys for the given hairdressing salon database relations.


question 2
the following tutuor and student tables show tutors who are assigned to students.
each student’s tutor is identified by the tutuorID column of the student table. The primary keys are underlined

Tutor

| tutorID | tutorName |
| ------- | --------- |
| 21      | Newman    |
| 34      | Martin    |
| 56      | Wright    |
| 78      | Adams     |

student


| StudentID | studentName | tutuorID |
| --------- | ----------- | -------- |
| 990199    | Young       | 56       |
| 990278    | Flecther    | 56       |
| 990445    | chung       | 45       |
| Null      | Cohen       | 21       |
| 990721    | Kennedy     | 78       |
a) Do these tables conform to the notions of entity integrity and referntial integrity? State the reasons for your answers
b) Draw an ER diagram representing these Tutor and student relations

Let's analyze the Tutor and Student tables regarding entity integrity and referential integrity, then create an ER diagram based on these relations.

### a) Entity Integrity and Referential Integrity

#### Entity Integrity
**Definition**: Entity integrity ensures that each table has a primary key and that the primary key is unique and not null.

- **Tutor Table**: 
  - The primary key is `tutorID`, which is unique and not null for all entries. Thus, the Tutor table satisfies entity integrity.

- **Student Table**: 
  - The primary key is `StudentID`, which is not fully satisfied. The `StudentID` column has a null value (for the student "Cohen"). Therefore, the Student table does **not** conform to entity integrity because a primary key cannot contain null values.

#### Referential Integrity
**Definition**: Referential integrity ensures that a foreign key in one table matches a primary key in another table or is null.

- In the Student table, the `tutorID` serves as a foreign key referencing the `tutorID` in the Tutor table.
- **Analysis of Foreign Key Values**:
  - `tutorID = 56`: Matches a valid tutor (Wright).
  - `tutorID = 45`: Does not match any existing `tutorID` in the Tutor table, which violates referential integrity.
  - `tutorID = 21`: Matches a valid tutor (Newman).
  - `tutorID = 78`: Matches a valid tutor (Adams).
  - `tutorID` can be null for students with no assigned tutor (though in practice, it would typically be set to a default value or managed differently).

Given the above analysis:
- The **Tutor table** conforms to both entity integrity and referential integrity.
- The **Student table** does not conform to entity integrity due to the null primary key and does not conform to referential integrity due to the invalid `tutorID` (45).

### b) ER Diagram Representation

Here's a simple representation of the ER diagram for the Tutor and Student relations:

```
+------------------+
|      Tutor       |
+------------------+
| * tutorID        | ← Primary Key
|   tutorName      |
+------------------+
         |
         | (1)      [tutors]     (M)
         +-------------------------+
         |                         |
         |                         |
+------------------+    +------------------+
|      Student     |    |      Student     |
+------------------+    +------------------+
| * StudentID      | ← Primary Key         |
|   studentName    |                       |
|   tutorID        | ← Foreign Key (FK)    |
+------------------+                       |
                                            |
                                            |
                                            |
                                   (M) <---------------------------+
                                            |
                                  [assigned to]                     |
                                            |                         |
                                            |                         |
+------------------+    +------------------+    +------------------+
|      Student     |    |      Student     |    |      Student     |
+------------------+    +------------------+    +------------------+
| * StudentID      | ← Primary Key         |    | * StudentID      | ← Primary Key
|   studentName    |                       |    |   studentName    |
|   tutorID        | ← Foreign Key (FK)    |    |   tutorID        |
+------------------+                       |    +------------------+
                                            |
                                            |
```

### Explanation of the ER Diagram:
- **Entities**:
  - **Tutor**: Represents the tutor information with a primary key `tutorID`.
  - **Student**: Represents student information with a primary key `StudentID`.
  
- **Relationships**:
  - There is a one-to-many relationship from **Tutor** to **Student**. A single tutor can be assigned to multiple students (indicated by the `(1) to (M)` notation). 
  - The `tutorID` in the **Student** table serves as a foreign key, linking back to the `Tutor` table.

### Summary
In summary, the Tutor table conforms to both integrity constraints, while the Student table fails to meet the requirements for both entity and referential integrity due to a null primary key and an invalid foreign key reference. The ER diagram visually represents the structure of these relations and their connections.

# Q3
A bakery uses a database system to record details about customers, products and orders. The system records customer details including the customer’s name, address and contact telephone number. A customer may place a number of orders, each of which requests various products. The system records the date on which each order was placed, the date the order is to be delivered, and the products requested. Each order is to be delivered to a unique customer, who may be different from the customer who placed that order (eg. a gift).
Each product has a unique name and unit price.
some products are made up of a combination of other products. For exxample, the ‘cocktail party selection’ consists of 5 ‘cheese starws’, 2 ‘sausage rolls, and 3 ‘vol au vents’.
a) construct an ER diagram to model the entities, attributes and relationships described above.
ensure that you show the participation and cardinality constraints that apply to each relationship
give a brief explanation of what each enitiy is intended to represent

b) use the techniques described in the lectures to convert your ER model into a set of relations.
highlight the primary key of each relation and clearly indicate any foreign keys

To model the bakery's database system with an ER diagram and then convert it into a set of relations, we will identify entities, attributes, and relationships based on the provided information. 

### a) ER Diagram

#### Entities and Attributes

1. **Customer**
   - **Attributes**:
     - `CustomerID` (Primary Key)
     - `Name`
     - `Address`
     - `Phone`

2. **Product**
   - **Attributes**:
     - `ProductID` (Primary Key)
     - `ProductName` (Unique)
     - `UnitPrice`

3. **Order**
   - **Attributes**:
     - `OrderID` (Primary Key)
     - `OrderDate`
     - `DeliveryDate`
     - `CustomerID` (Foreign Key, refers to Customer)

4. **OrderItem** (For products requested in each order)
   - **Attributes**:
     - `OrderItemID` (Primary Key)
     - `OrderID` (Foreign Key, refers to Order)
     - `ProductID` (Foreign Key, refers to Product)
     - `Quantity` (Number of units of the product)

5. **CompositeProduct** (For products made up of combinations of other products)
   - **Attributes**:
     - `CompositeProductID` (Primary Key)
     - `ProductID` (Foreign Key, refers to Product)
     - `ComponentProductID` (Foreign Key, refers to Product)
     - `ComponentQuantity` (Number of units of the component product)

#### Relationships

1. **Customer to Order**: 
   - A customer can place zero or more orders (1:N).
   - Each order is delivered to one customer (N:1).

2. **Order to OrderItem**:
   - An order can include one or more products (1:N).
   - Each order item belongs to one order (N:1).

3. **Product to OrderItem**:
   - A product can appear in multiple order items (1:N).
   - Each order item refers to one product (N:1).

4. **Product to CompositeProduct**:
   - A composite product can consist of one or more products (1:N).
   - Each component product belongs to one composite product (N:1).

#### ER Diagram

```plaintext
+------------------+       +-----------------+        +-----------------+
|     Customer     |       |      Order      |        |     Product     |
+------------------+       +-----------------+        +-----------------+
| * CustomerID     |◄───── | * OrderID       |        | * ProductID     |
|   Name           |       |   OrderDate     |        |   ProductName   |
|   Address        |       |   DeliveryDate  |        |   UnitPrice     |
|   Phone          |       |   CustomerID (FK) ─────────── (Unique) |
+------------------+       +-----------------+        +-----------------+
                                     |
                                     | (1)
                                     |
                                     | (N)
+-------------------+               |
|    OrderItem      |               |
+-------------------+               |
| * OrderItemID     |               |
|   OrderID (FK)    |───────────────+
|   ProductID (FK)  |
|   Quantity        |
+-------------------+

                                   |
                                   | (1)
                                   |
                                   | (N)
                                   |
+-------------------+             |
| CompositeProduct   |             |
+-------------------+             |
| * CompositeProductID|             |
|   ProductID (FK)   |             |
|   ComponentProductID (FK) |
|   ComponentQuantity |             |
+-------------------+             |
```

### Explanation of Entities

- **Customer**: Represents the details of each customer, including their unique identifier and contact information.
- **Product**: Represents the details of each product available for order, including a unique identifier and pricing.
- **Order**: Represents individual orders placed by customers, including the associated dates and the customer for whom the order is intended.
- **OrderItem**: Represents the specific products requested within each order, linking each product to the order and indicating how many units were requested.
- **CompositeProduct**: Represents products that are combinations of other products, detailing which products make up the composite and the quantities required.

### b) Set of Relations

Now we will convert the ER model into a set of relations, highlighting primary keys (PK) and foreign keys (FK):

1. **Customer**
   - **Attributes**:
     - `CustomerID` (PK)
     - `Name`
     - `Address`
     - `Phone`

2. **Product**
   - **Attributes**:
     - `ProductID` (PK)
     - `ProductName` (Unique)
     - `UnitPrice`

3. **Order**
   - **Attributes**:
     - `OrderID` (PK)
     - `OrderDate`
     - `DeliveryDate`
     - `CustomerID` (FK references Customer)

4. **OrderItem**
   - **Attributes**:
     - `OrderItemID` (PK)
     - `OrderID` (FK references Order)
     - `ProductID` (FK references Product)
     - `Quantity`

5. **CompositeProduct**
   - **Attributes**:
     - `CompositeProductID` (PK)
     - `ProductID` (FK references Product)
     - `ComponentProductID` (FK references Product)
     - `ComponentQuantity`

### Summary of Relations

| Relation             | Attributes                                                           | Primary Key        | Foreign Keys                                                                  |
| -------------------- | -------------------------------------------------------------------- | ------------------ | ----------------------------------------------------------------------------- |
| **Customer**         | CustomerID, Name, Address, Phone                                     | CustomerID         | None                                                                          |
| **Product**          | ProductID, ProductName, UnitPrice                                    | ProductID          | None                                                                          |
| **Order**            | OrderID, OrderDate, DeliveryDate, CustomerID                         | OrderID            | CustomerID (FK references Customer)                                           |
| **OrderItem**        | OrderItemID, OrderID, ProductID, Quantity                            | OrderItemID        | OrderID (FK references Order), ProductID (FK references Product)              |
| **CompositeProduct** | CompositeProductID, ProductID, ComponentProductID, ComponentQuantity | CompositeProductID | ProductID (FK references Product), ComponentProductID (FK references Product) |

This structure clearly delineates the entities, their relationships, and the attributes, along with specifying primary and foreign keys for maintaining data integrity in the bakery's database system.