#!/bin/bash

# Exit immediately if a command exits with a non-zero status.
set -e

# Define service directories
SERVICES=("api-gateway" "player" "session" "participant")
K8S_DIR="k8s"

# --- Build Stage ---
echo "Building Spring Boot applications and Docker images..."

for service in "${SERVICES[@]}"; do
  echo "--- Building $service ---"
  cd "$service"
  
  # Use Maven wrapper to build the project and Docker image
  # The spring-boot-maven-plugin's build-image goal creates the Docker image
  echo "Running Maven build and Docker image creation for $service..."
  ./mvnw spring-boot:build-image -DskipTests
  
  # Optional: Tag the image if needed (e.g., with a specific registry)
  # docker tag <image-name-from-pom.xml>:<version> your-registry/$service:<version>
  # docker push your-registry/$service:<version>
  
  cd .. # Go back to the root directory
  echo "--- Finished building $service ---"
done

echo "All services built successfully."

# --- Deployment Stage ---
echo "Deploying services to Kubernetes..."

# Apply MySQL deployment first (as other services might depend on it)
echo "--- Deploying MySQL ---"
kubectl apply -f "$K8S_DIR/mysql-deployment.yaml"

# Wait a bit for MySQL to potentially start up (adjust time if needed)
echo "Waiting for MySQL to initialize..."
sleep 15 

# Apply deployments for the services
echo "--- Deploying Player Service ---"
kubectl apply -f "$K8S_DIR/player-deployment.yaml"

echo "--- Deploying Session Service ---"
kubectl apply -f "$K8S_DIR/session-deployment.yaml"

echo "--- Deploying Participant Service ---"
kubectl apply -f "$K8S_DIR/participant-deployment.yaml"

# Apply API Gateway deployment last
echo "--- Deploying API Gateway ---"
kubectl apply -f "$K8S_DIR/api-gateway-deployment.yaml"

echo "--- Deployment process initiated. ---"
echo "Use 'kubectl get pods -w' to monitor the status of the pods."
echo "Use 'kubectl get services' to find the external IP/port for the API Gateway (if using LoadBalancer)."