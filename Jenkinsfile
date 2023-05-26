pipeline {

    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }

    agent any

    tools {
        maven 'Maven_3.8.8'
    }
    stages {
        stage('Code Compilation') {
            steps {
                echo 'code compilation is starting'
                sh 'mvn clean compile'
				echo 'code compilation is completed'
            }
        }

        stage('Sonarqube') {
            environment {
                scannerHome = tool 'qube'
            }
            steps {
                withSonarQubeEnv('sonar-server') {
                    sh "${scannerHome}/bin/sonar-scanner"
                    sh 'mvn sonar:sonar'
                }
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Code Package') {
            steps {
                echo 'code packing is starting'
                sh 'mvn clean package'
				echo 'code packing is completed'
            }
        }
        stage('Building & Tag Docker Image') {
            steps {
                echo 'Starting Building Docker Image'
                sh 'docker build -t kusumwakare/restro-ms .'
                 sh 'docker build -t restro-ms .' 
                echo 'Completed  Building Docker Image'
            }
        }
        stage('Docker Image Scanning') {
            steps {
                echo 'Docker Image Scanning Started'
                sh 'java -version'
                echo 'Docker Image Scanning Started'
            }
        }
        stage(' Docker push to Docker Hub') {
           steps {
              script {
                 withCredentials([string(credentialsId: 'dockerhubCred', variable: 'dockerhubCred')]){
                 sh 'docker login docker.io -u kusumwakare -p ${dockerhubCred}'
                 echo "Push Docker Image to DockerHub : In Progress"
                 sh 'docker push kusumwakare/restro-ms:latest'
                 echo "Push Docker Image to DockerHub : In Progress"
                 sh 'whoami'
                 }
              }
            }
        }
        stage(' Docker Image Push to Amazon ECR') {
           steps {
              script {
                 docker.withRegistry('https://701158536369.dkr.ecr.ap-south-1.amazonaws.com/restro-ms', 'ecr:ap-south-1:ecr-cred'){
                 sh """
                 echo "List the docker images present in local"
                 docker images
                 echo "Tagging the Docker Image: In Progress"
                 docker tag restro-ms:latest 701158536369.dkr.ecr.ap-south-1.amazonaws.com/restro-ms:latest
                 echo "Tagging the Docker Image: Completed"
                 echo "Push Docker Image to ECR : In Progress"
                 docker push 701158536369.dkr.ecr.ap-south-1.amazonaws.com/restro-ms:latest
                 echo "Push Docker Image to ECR : Completed"
                 """
                 }
              }
           }
        }
        /*stage('Upload Docker Images to Nexus') {
            steps {
                script {
                    withCredentials{[usernamePassword(credentialsId: 'nexus-cred', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]} {
                    sh 'docker login http://43.204.36.212:8085/repository/restro-ms/ -u admin -p $(PASSWORD)'
                    echo "Push Docker Image to Nexus : In Progress"
                    sh 'docker tag restro-ms 43.204.36.212:8085/restro-ms:latest'
                    sh 'docker push 43.204.36.212:8085/restro-ms'
                    echo "Push Docker Image to Nexus : Completed"
                    }
                }
            }
        } */
    }
}