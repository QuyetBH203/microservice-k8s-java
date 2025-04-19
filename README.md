# Chess Management Microservices Project

This project implements a chess management system using a microservices architecture deployed on Kubernetes.

## Project Structure

```
deploy-k8s/
├── api-gateway/      # Spring Cloud Gateway service
├── k8s/              # Kubernetes deployment files (.yaml)
├── participant/      # Participant microservice
├── player/           # Player microservice
├── session/          # Session microservice
├── deploy.sh         # Deployment script
└── README.md         # This file
```

The project is organized into the following main components:

-   **`api-gateway/`**: Contains the Spring Cloud Gateway service, acting as the single entry point for all incoming requests and routing them to the appropriate microservice.
-   **`player/`**: Contains the Player microservice, responsible for managing player data.
-   **`session/`**: Contains the Session microservice, responsible for managing game session data.
-   **`participant/`**: Contains the Participant microservice, responsible for managing participants within game sessions, potentially linking players and sessions.
-   **`k8s/`**: Contains Kubernetes deployment configuration files (`.yaml`) for each service (including MySQL database and the API Gateway).
-   **`README.md`**: This file.
-   **`deploy.sh`**: A shell script to automate the build and deployment process to Kubernetes.

## Architecture Overview

The system follows a microservices pattern:

1.  **API Gateway**: Handles external requests and directs traffic to the relevant backend service.
2.  **Player Service**: Manages player information (CRUD operations).
3.  **Session Service**: Manages game session details (creation, status updates, etc.).
4.  **Participant Service**: Manages the relationship between players and sessions (who is participating in which game).
5.  **MySQL Database**: Provides persistent storage, likely used by multiple services (configured via `k8s/mysql-deployment.yaml`).
6.  **Kubernetes (k8s)**: Orchestrates the deployment, scaling, and management of the containerized services.

*(A visual diagram would typically go here, showing the interaction between the API Gateway, the three core services, and the database, all running within a Kubernetes cluster.)*

## Deployment

To build the Docker images and deploy all services to your configured Kubernetes cluster, run the deployment script:

```bash
./deploy.sh