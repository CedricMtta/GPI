 pipeline {
    agent any
    tools {
        maven 'M3' 
        jdk 'jdk8u125'
    }
    
    environment {
		// Définition du path qui sera utilisé dans tomcat et la doc 
		def deployPath = 'GPImages'

		// obligatoire car il est impossible de resoudre workspace dans l'appel
		def warPath = "${workspace}/target"
    }
           
    stages {   
    
    	stage('Env') {
			steps{
			    // récupération du fichier de configuration du tcat1, stocké dans Jenkins
				configFileProvider([configFile(fileId:'tomcat1-conf', variable: 'tomcatConfFile')]) {
					script{
						// On assigne la valeur du fichier de conf à une variable d'environnement du Job
						def tomcatConf = readJSON(text: readFile(file: tomcatConfFile))
						env.deployUrl = "$tomcatConf.tomcat.deploy.url"
					}
				}
				
			}
		}

        stage('Checkout'){
            steps{
                   git 'https://github.com/CedricMtta/GPI.git'
            }
        }
                         
        stage('Test'){
            steps{
                sh "mvn clean test"
            }
        }
        
        stage('Package'){
            steps{
                // compilation et archivage de l'artefact
                sh "mvn package -DskipTests=true"
            }
            post {
                success{
                        archiveArtifacts artifacts: 'target/*.war'
                }
            }
        }
        
        stage('generate_swagger'){
        	steps{
        		sh "mvn compile"
        	}
        }
        
        stage('Deploy'){
        	steps{
			    // récupération des crédentials stockés dans jenkins
                withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'tomcatdeploy', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
					
					// redéploiement en utilisant les identifiants et les paramètres de conf
					sh 'curl -T "${warPath}/GPImages.war" "http://$USERNAME:$PASSWORD@${deployUrl}/manager/text/deploy?path=/${deployPath}&update=true"'
					
                }
            }
        
        }
       
        }        
        post{
	        always{
	            // TOUJOURS nettoyer le workspace
	                 cleanWs()
	        }
    	}
}
