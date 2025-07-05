# Vault
## Description
This is a secure vault backend for Spring Cloud Config Server. It uses Hashicorp Vault. This folder contains the simple 
configuration skeleton that needs to be filled out for the vault to be usable in production with persistence.

## Setup
In order to make it work, you need to provide TLS key and certificate inside the ./vault/certs directory.

The data (secrets) is persisted in data directory as docker bind mount.

This folder contains its own docker compose because setting it up is tricky. The setup requires generating unseal keys 
and root token when accessing the vault for the first time and using these generated values in order to start the services.
For that to work, OS environment variables can be used in a .env file.

You need to unseal the vault manually each time before starting the dependent services. This can later be automated when
you have configured your vault security to your liking.

* Note: If you are uncomfortable with setting up and maintaining vault, you can use the native profile of config-server 
and load filesystem configs.
