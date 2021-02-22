pipeline {
    agent any

    triggers{
        pollSCM('* * * * *')
    }

    tools{
        maven 'maven-3'
        jdk 'java11'
    }

    stages{
        stage('Maven-Clean'){
            steps{
                bat 'mvn clean'
            }
        }
        stage('Maven-Validate'){
            steps{
                bat 'mvn validate'
            }
        }
        stage('Maven-Compile'){
            steps{
                bat 'mvn compile'
            }
        }
        stage('Maven-Test'){
            steps{
                bat 'mvn test'
            }
        }
        stage('Maven-Package'){
            steps{
                bat 'mvn package'
            }
        }
        stage('Maven-Install'){
            steps{
                bat 'mvn install'
            }
        }
         stage('Maven-SonarCloud Analysis'){
            steps{
                withSonarQubeEnv('sonarqube3'){
                    bat 'mvn sonar:sonar'
                }
                
            }
        }

        stage('Artifactory-Upload'){
            steps{
                rtUpload(
                    serverId: 'artifactoryserver',
                    spec :'''{
                        "files":[
                            {
                                     "pattern":"target/*.jar"
                            "target":"art-doc-dev-local/"
                            }
                           
                            ]

                    }''',
                     buildName: 'holyFrog',
                    buildNumber: '1'
                )
            }
        }
    }
}