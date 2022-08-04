# java-read-email

This sample will show you to easily read messages from your inbox with the Nylas Java SDK.

## Setup

### System dependencies

- Java 18.0.2
- Maven 3.8.6

### Gather environment variables

You'll need the following values:

```text
ACCESS_TOKEN = ""
```

Add the above values to a new `.env` file:

```bash
$ touch .env # Then add your env variables
```

### Install dependencies

```bash
org.slf4j / slf4j-simple / 1.7.25
com.nylas.sdk / nylas-java-sdk / 1.15.0
io.github.cdimascio / dotenv-java / 2.2.4
```

# Compilation

To compile we need to use this `maven` command:

```bash
mvn package
```

## Usage

Run the app using the `maven` command:

```bash
$ mvn exec:java -Dexec.mainClass="ReadInbox"
```

When successfull, it will display the first 5 emails in your inbox


## Learn more

Visit our [Nylas Java SDK documentation](https://developer.nylas.com/docs/developer-tools/sdk/java-sdk/) to learn more.
