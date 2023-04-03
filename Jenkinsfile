pipeline {

    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }

    agent any

    tools {
        maven 'Maven_3.8.8'
    }
    stages {
        stage('chk Java version') {
            steps {
                echo 'checking java version'
                sh 'java --version'
				echo 'java version is'
            }
        }
        stage('Code Compile') {
            steps {
                echo 'code compilation is starting'
                sh 'mvn clean compile'
				echo 'code compilation is completed'
            }
        }
        stage('Code test') {
            steps {
                echo 'code compilation is starting'
                sh 'mvn clean test'
				echo 'code compilation is completed'
            }
        }
        stage('Docker Image') {
            steps {
                echo 'code packing is starting'
                sh 'java --version'
				echo 'code packing is completed'
            }
        }
    }
}