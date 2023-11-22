// shared-library/vars/commonFunctions.groovy

def callCheckout(def stages, def gitUrl) {
    stages.stage('Checkout') {
        steps {
            checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: gitUrl]])
            sh 'echo "Building the project"'
        }
    }
}

def buildImage(def stages) {
    stages.stage('build image') {
        steps {
            script {
                sh 'docker build -t jaydeep .'
            }
        }
    }
}

def accessImageLocally(def stages) {
    stages.stage('access image locally') {
        steps {
            script {
                sh 'docker run -p 8085:3000 jaydeep'
            }
        }
    }
}
