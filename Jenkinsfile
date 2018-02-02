pipeline {
    agent any
    tools {
        maven 'M3' 
        jdk 'jdk8u125'
    }
    
	environment {
		// définition du path qui sera utilisé dans tomcat et la doc 
		def deployPath = 'GestionProjetImage'

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
				
				// récupération du fichier de configuration d'apache
				configFileProvider([configFile(fileId:'apache-conf', variable: 'apacheConfFile')]) {
					script{
						def apacheConf = readJSON(text: readFile(file: apacheConfFile))
						env.publicApacheRoot = "$apacheConf.publichtml.root"
						env.publicApacheDoc = "$apacheConf.publichtml.doc"
					}
				}
			}
		}
		
		stage('Test'){
            steps{
                sh "mvn clean test"
            }
        }
        
        stage('Package'){
            steps{
                sh "mvn package -DskipTests=true"
            }
			post{
				success{
					archiveArtifacts artifacts: 'target/*.war'
				}
			}
        }		
           		
		stage('Analyse SonarQube') {
			steps{
				withSonarQubeEnv('sonarqube') {      
					sh "mvn sonar:sonar"
				}
			}
		}
		
		stage('Integration'){
            steps{
				// passe les tests d'integration
                sh "mvn integration-test"				
            }
        }
		
        stage('Génération de la doc technique'){
			parallel {
				stage('Javadoc'){
					steps{
						sh "mvn javadoc:javadoc"
					}
				}
				stage('Swagger Api'){
					steps{
						sh "mvn com.github.kongchen:swagger-maven-plugin:generate"
					}
					post{
						success{
							archiveArtifacts artifacts: 'target/swagger-ui/*.yaml'
						}
					}
				}
			}
        }
        
        stage('Deploy'){
            steps{
			    // récupération des crédentaisl stockés dans jenkins
                withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'tomcatdeploy', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
					
					// redéploiement en utilisant les identifiants et les paramètres de conf
					sh 'curl -T "${warPath}/GestionProjetImage.war" "http://$USERNAME:$PASSWORD@${deployUrl}/manager/text/deploy?path=/${deployPath}&update=true"'
					
                }
            }
        }
        
        stage('Déploiement de la documentation'){
            parallel {
                
                stage('Deploy javadoc'){
                    steps{
						sh "mkdir -p ${publicApacheDoc}/GestionProjetImage-javadoc"
                        sh "cp -R target/site/apidocs/* ${publicApacheDoc}/GestionProjetImage-javadoc"
                    }
                }
            
                stage('Publish asciidoc'){
                    steps{
                        publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/generated-docs', reportFiles: 'GestionProjetImage.html', reportName: 'AsciiDoc', reportTitles: 'documentation'])
                    }
                }
                stage('Publish javadoc'){
                    steps{
                        publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/site/apidocs', reportFiles: 'index.html', reportName: 'JavaDoc', reportTitles: 'JavaDoc'])
                    }
                }
            }
        }
    }
    
    
    post{
        always{
            // enregistre toujours les rapports de test
            //junit 'target/surefire-reports/TEST-*.xml'           
			
			
			// enregistre toujours les rapports JSON pour le build (pour voir les échecs)
			cucumber '**/*.json'
		
			// enregistre les rapports HTML (pour voir les échecs)
			publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/cucumber', reportFiles: 'index.html', reportName: 'Rapports cucumber', reportTitles: 'Rapport de tests cucumbers'])
			
			
			// TOUJOURS nettoyer le workspace
			cleanWs()
        }
    }
}