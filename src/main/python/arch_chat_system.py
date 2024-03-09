from diagrams import Diagram
from diagrams.aws.compute import EC2, Lambda
from diagrams.aws.security import Cognito
from diagrams.aws.general import User
from diagrams.aws.database import DDB as Dynamodb
from diagrams.aws.integration import Appsync
from diagrams import Edge, Cluster


with Diagram("arch_chat_system", show=True, direction="TB"):
    with Cluster("Mobile App"):
        rider = User("Rider")
        driver = User("Driver")

    with Cluster("AWS"):
        with Cluster("Security"):
            cognito = Cognito("Cognito")
            rider >> Edge(Label="sign-up/sign-in") >> cognito
            cognito >> Edge(Label="jwt") >> rider
            driver >> Edge(Label="sign-up/sign-in") >> cognito
            cognito >> Edge(Label="jwt") >> driver

        # API
        with Cluster("API"):
            appSync = Appsync("AppSync API")
            driver >> Edge(label="chat") >> appSync
            rider >> Edge(label="chat") >> appSync
            appSync  >> Edge(label="subscriptions") >> driver
            appSync >> Edge(label="subscriptions") >> rider
            userSignupLambda = Lambda("User Signup Lambda")
            cognito >> Edge(label="auth") >> appSync



        # DynamoDB
        with Cluster("DynamoDB"):
            usersTable = Dynamodb("Users Table")
            messagesTable = Dynamodb("Messages Table")
            conversationsTable = Dynamodb("Conversations Table")
            appSync >> usersTable
            appSync >> conversationsTable
            appSync >> messagesTable
            cognito >> userSignupLambda >> usersTable











