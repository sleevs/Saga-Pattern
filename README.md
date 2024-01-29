# Saga-Pattern

Demonstration of distributed transactions in microservice architecture 

The systems is a sequencial of transaction beetwen client and the microservice app . A saga is sequence of local transactions that are coordinated using messaging. Each local transaction updates data in a single service. Because each local transaction commits its
changes, if a saga must roll back due to the violation of a business rule, it must execute compensating transactions to explicitly undo changes.

  Service Order 
                
                The first step of transaction which receiver requisition from client or external system through API
                Service Order create an order and register the status of order as "processing state" and publish to message-broker 
                to next service operating in this transaction .

Service Paymento   
                
                a) Is the second step  of sequencial transaction which consumes the event from Order Service through message-broker  
                b) The Payment Service verify data event and try to make the payment process
                c) if not ocurred the payment process the Payment Service must roll back the process.
                d) otherwise the payment ocurred OK and then the Payment Service must register the 
                    processing in database as "PROCESSING" 
                e) And then the Payment Service must publish to message-broker to next service operating in this transaction .
                     
                   
Shippiment Service   
                      
                a) The third step of sequence the Shippiment Service consumes the event from Payment Service through message-broker  
                b) The Shippiment Service verify the data event and try to make the shippment process
                c) if not ocurred the shippment process the Shippiment Service must roll back the process.
                d) otherwise the shippment ocurred OK and then the Shippiment Service must register the 
                    processing in database as status "PROCESSING" 
                e) And then the Shippiment Service must publish to message-broker to next service operating in this transaction .


Notification Service 

               a) The final step of sequence of transactions is the Notification Service consumes the event from Shippiment Service 
                   through message-broker  
               b) The Notification Service verify the data event and try to make the communication with app client or external system                           process the communication is asynchronous so when the user be online they will receiver de notification.
               d) otherwise the user be online then the Notification Service must register the 
                   processing in database as status "PROCESSING" 
               e) And then the Notification Service must publish to message-broker to changes the state of the Order to APPROVED, and                            publishes an OrderApproved event.
                     


