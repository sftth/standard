pipeline {
    agent any

    parameters {
        string(name: 'MVN_HOME', defaultValue: '/sorc001/appadm/ciserv/maven', description: 'Maven Installation Home')
    }

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage('Build') {
            steps {
                echo '========1. Maven Build ========'
                sh '${params.MVN_HOME}/bin/mvn clean package'
            }
        }
    }
}