pipeline {
    agent any

    stages {
        stage('Início') {
            steps {
                sh 'echo início'
            }
        }
        stage('Meio') {
            steps {
                sh 'echo meio'
                sh 'echo meio travez'
            }
        }
        stage('Fim') {
            steps {
                sleep(5)
                sh 'echo Fim!'
            }
        }
    }
}
