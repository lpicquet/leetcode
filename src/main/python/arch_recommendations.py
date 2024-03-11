from diagrams import Diagram
from diagrams.aws.compute import Lambda
from diagrams.aws.security import Cognito
from diagrams.aws.general import User
from diagrams.aws.database import DDB as Dynamodb, Timestream
from diagrams import Edge, Cluster
from diagrams.aws.network import APIGateway
from diagrams.aws.analytics import KinesisDataStreams
from diagrams.aws.ml import Sagemaker, SagemakerModel, SagemakerTrainingJob



with Diagram("arch_recommendations", show=False, direction="TB"):
    with Cluster("Mobile App"):
        user = User("User")

    with Cluster("AWS"):
        with Cluster("Security"):
            cognito = Cognito("Cognito")
            user >> Edge(Label="sign-up/sign-in") >> cognito
            cognito >> Edge(Label="jwt") >> user

        # API
        with Cluster("API"):
            apiGateway = APIGateway("API Gateway")
            user >> Edge(label="recommendations") >> apiGateway
            recommendationsLambda = Lambda("Recommendations\nLambda")
            apiGateway >> Edge(label="") >> recommendationsLambda

        # DynamoDB
        with Cluster("DynamoDB"):
            usersOrdersTable = Dynamodb("Users Orders Table")
            recommendationsTable = Dynamodb("Recommendations Table")
            timestream = Timestream("data stream")
            usersOrdersTable >> Edge(label="stream") >> timestream
            recommendationsLambda << Edge(label="fetch") << recommendationsTable


        with Cluster("Machine learning"):
            kinesisDataStreams = KinesisDataStreams("Kinesis Data Streams")
            timestream >> Edge(label="") >> kinesisDataStreams
            sageMakerModel = SagemakerModel("SageMaker Model")
            sagemakerTrainingJob = SagemakerTrainingJob("SageMaker Training Job")

            kinesisDataStreams >> Edge(label="") >> sageMakerModel
            sageMakerModel >> Edge(label="recommendations") >> recommendationsTable
            usersOrdersTable >> Edge(label="fetch") >> sagemakerTrainingJob
            sagemakerTrainingJob >> Edge(label="train") >> sageMakerModel
