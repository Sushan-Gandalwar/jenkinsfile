// Jenkinsfile

pipeline {
    agent any

    parameters {
        string(name: 'GIT_URL', description: 'By GitHub Repository URL')
        string(name: 'image_name', description: 'image name')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: params.GIT_URL]])
                sh 'echo "Building the project"'
            }
        }

        stage('build image') {
            steps {
                script {
                    sh 'docker build -t {params.image_name} .'
                }
            }
        }

        stage('access image locally') {
            steps {
                script {
                    sh 'docker run -p 8085:3000 {params.image_name}'
                }
            }
        }
    }
}
