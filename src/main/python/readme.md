# architecture Diagram exercises

## Setup

```bash
brew install graphviz
python3 -m pip install --upgrade pip
python3 -m pip install virtualenv
python3 -m virtualenv venv
source venv/bin/activate
python3 -m pip install --upgrade pip
python3 -m pip  install -r requirements.txt
```

## Run

```bash
python3 arch_chat_system.py
open arch_chat_system.png
python3 arch_recommendations.py
open arch_recommendations.png
```

## Example data - arch_chat_system - single dynamodb table

| PK         | SK             | type         | user_id    | conversation_id | message_id     | enc_conversation_key | content                              | comment                                         |
|------------|----------------|--------------|------------|-----------------|----------------|----------------------|--------------------------------------|-------------------------------------------------|
| user#12345 |                | user         | user#12345 |                 |                |                      |                                      |                                                 |
| user#12346 |                | user         | user#12346 |                 |                |                      |                                      |                                                 |
| user#12347 |                | user         | user#12347 |                 |                |                      |                                      |                                                 |
| user#12348 |                | user         | user#12348 |                 |                |                      |                                      |                                                 |
| conv#5678  |                | conversation |            |                 |                | ABC (KMS encrypted)  | 6DAf99FFGa ('Hello world' encrypted) | symmetric key used to encrypt/decrypt messages. |
| conv#5678  | user#12345     | participant  | user#12345 | conv#5678       |                |                      |                                      |                                                 |
| conv#5678  | user#12346     | participant  | user#12345 | conv#5678       |                |                      |                                      |                                                 |
| conv#5678  | user#12347     | participant  | user#12345 | conv#5678       |                |                      |                                      |                                                 |
| conv#5678  | user#12347     | participant  | user#12345 | conv#5678       |                |                      |                                      |                                                 |
| conv#5678  | msg#4567700909 | message      | user#12345 | conv#5678       | msg#4567700909 |                      | 6DAf99 ('Hello' encrypted)           |                                                 |                
                                                                                                                                         