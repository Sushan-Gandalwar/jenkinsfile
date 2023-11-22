// shared-library-repo/vars/commonFunctions.groovy

def callCheckout(def stages, def gitUrl) {
    stages.stage('Checkout') {
        steps {
            checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: gitUrl]])
            sh 'echo "Building the project"'
        }
    }
}

def buildImage(def stages, def imageName) {
    stages.stage('Build image') {
        steps {
            script {
                sh "docker build -t ${imageName} ."
            }
        }
    }
}

def accessImageLocally(def stages, def port, def imageName) {
    stages.stage('Access image locally') {
        steps {
            script {
                sh "docker run -p ${port}:3000 ${imageName}"
            }
        }
    }
}
