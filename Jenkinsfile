pipeline {
    agent any

    parameters {
        string(name: 'MVN_HOME', defaultValue: '/sorc001/appadm/ciserv/maven', description: 'Maven Installation Home')
        string(name: 'DEV_SERVER', defaultValue: '172.31.10.39', description: 'Dev Server IP')
    }

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage('Build') {
            steps {
                echo '========1. Maven Build========'
                sh "${params.MVN_HOME}/bin/mvn clean package"
            }
        }
        stage('Deploy to dev') {
            steps {
                echo '========2. Erase Legacy Jar======='
                sh "ssh -i /home/ec2-user/sftth322-keypair.pem -o StrictHostKeyChecking=no ec2-user@${params.DEV_SERVER} rm -rf /sorc001/appadm/application/*.jar"

                echo '========3. Deploy to Dev======='
                sh "scp -i /home/ec2-user/sftth322-keypair.pem -o StrictHostKeyChecking=no ./target/*.jar ec2-user@${params.DEV_SERVER}:/sorc001/appadm/application"

                //echo '========4. Start SpringBoot======='
                //sh "ssh -i /home/ec2-user/sftth322-keypair.pem -o StrictHostKeyChecking=no ec2-user@${params.dev_server} java -jar /sorc001/appadm/application/standard-0.0.1-SNAPSHOT.jar"

            }
        }
    }
}