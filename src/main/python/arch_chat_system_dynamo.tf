# Configure the AWS provider
provider "aws" {
  region = "us-east-1" # Replace with your desired region
}

# Users table
resource "aws_dynamodb_table" "users" {
  name           = "Users"
  billing_mode  = "PAY_PER_REQUEST"
  hash_key       = "userId" # String (Primary Key)
  attribute {
    name = "userId"
    type = "S"
  }
  attribute {
    name = "firstName"
    type = "S"
  }
  attribute {
    name = "lastName"
    type = "S"
  }
  attribute {
    name = "phoneNumber"
    type = "S"
  }
  attribute {
    name = "email"
    type = "S"
  }

  # GSI for efficient email lookup
  global_secondary_index {
    name  = "username-index"
    hash_key = "email" # String
    range_key {
      name = "userId" # String
      type = "S"
    }
    projection {
      projection_type = "ALL"
    }
  }
}

# Conversations table
resource "aws_dynamodb_table" "conversations" {
  name           = "Conversations"
  billing_mode  = "PAY_PER_REQUEST"
  hash_key       = "conversationId" # String (Primary Key)
  attribute {
    name = "conversationId"
    type = "S"
  }
  attribute {
    name = "participants" # Set of Strings
    type = "SS"
  }
  attribute {
    name = "createdAt"
    type = "S"
  }
  attribute {
    name = "lastActive"
    type = "S"
  }

  # GSI for efficient retrieval by participant
  global_secondary_index {
    name  = "participant-index"
    hash_key = "participantId" # String from participants set
    range_key {
      name = "conversationId" # String
      type = "S"
    }
    projection {
      projection_type = "ALL"
    }
  }
}

# Messages table
resource "aws_dynamodb_table" "messages" {
  name           = "Messages"
  billing_mode  = "PAY_PER_REQUEST"
  hash_key       = "messageId" # String (Primary Key)
  range_key       = "sentAt"   # String (for sorting)
  attribute {
    name = "messageId"
    type = "S"
  }
  attribute {
    name = "conversationId"
    type = "S"
  }
  attribute {
    name = "senderId"
    type = "S"
  }
  attribute {
    name = "content"
    type = "S"
  }
  attribute {
    name = "sentAt"
    type = "S"
  }
}
