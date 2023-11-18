pipeline {
    agent any

    stages {
        stage('build image') {
            steps {
                script {
                    sh 'docker build -t jaydeep .'
                }
            }
        }
        stage('access image locally'){
            steps{
                script{
                    sh 'docker run -p 8085:3000 jaydeep'
                }
            }
        }

    }
}

