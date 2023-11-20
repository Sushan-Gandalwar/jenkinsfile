pipeline {
    agent any

    parameters {
        string(name: 'GIT_URL', description: 'GitHub Repository URL')
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
                    sh 'docker build -t jaydeep .'
                }
            }
        }

        stage('access image locally') {
            steps {
                script {
                    sh 'docker run -p 8085:3000 jaydeep'
                }
            }
        }
    }
}
