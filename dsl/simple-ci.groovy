def gitUrl = 'https://github.com/idlv75/hello-world-war'

job('SimpleCI') {
	logRotator {
      daysToKeep(-1)
      numToKeep(10)
    }
	parameters {
		booleanParam("RELEASE", false)
	}
	triggers { scm('H/5 * * * *') }
    scm {
        git(gitUrl)
    }
	steps {
		conditionalSteps {
			condition {
				stringsMatch('${RELEASE}', 'false', true)
			}
			steps {
				maven('clean install')
			}
		}
    }
	wrappers {
		preBuildCleanup()
		release {
			preBuildSteps {
				steps {
					conditionalSteps {
						condition {
							stringsMatch('${RELEASE}', 'true', true)
						}
						steps {
							maven('-B clean release:clean release:prepare')
						}
					}
				}             
            }
			postSuccessfulBuildSteps {
				steps {
					conditionalSteps {
						condition {
							stringsMatch('${RELEASE}', 'true', true)
						}
						steps {
							maven('release:perform -Dmaven.deploy.skip=true')
						}
					}
				}
			}
		}	
	}
}