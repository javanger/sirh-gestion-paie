pipeline {
    agent any
    environment {
        DEV_ID = 'Emmanuel' 
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent package'
            }
        }
        stage('quality') {
            steps {
                withSonarQubeEnv('Sonar-Nantes') {
                  sh "mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar -Dsonar.projectKey=${DEV_ID}-sirh-paie -Dsonar.projectName=${DEV_ID}-sirh-paie -Dsonar.projectVersion=1.0 -Dsonar.sourceEncoding=UTF-8"
                }
            }
        }
    }
    post {
        success {
           slackSend channel: '#jenkins_nantes', color: 'good', message: "Bravo  ${DEV_ID}! ${env.JOB_NAME} commit ${env.GIT_COMMIT} (<${env.BUILD_URL}|Open>)"
        }
        unstable {
            slackSend channel: '#jenkins_nantes', color: 'warning', message: "Attention ${DEV_ID} ! ${env.JOB_NAME} commit ${env.GIT_COMMIT} (<${env.BUILD_URL}|Open>)" 
        }
        failure {
           slackSend channel: '#jenkins_nantes', color: 'danger', message: "Oops ${DEV_ID}! ${env.JOB_NAME} commit ${env.GIT_COMMIT} (<${env.BUILD_URL}|Open>)"
        }
    }
}