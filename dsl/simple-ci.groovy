job('SimpleCI2') {
	logRotator {
      daysToKeep(-1)
      numToKeep(10)
    }
	parameters {
		booleanParam("RELEASE", false)
	}
	triggers { scm('H/15 * * * *') }
    scm {
		git {
			remote {
				github('idlv75/hello-world-war')
				credentials('github-jenkins-PK')
				extensions {
					wipeOutWorkspace()
					localBranch('master')
				}
			}
		}
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
		conditionalSteps {
			condition {
				stringsMatch('${RELEASE}', 'true', true)
			}
			steps {
				maven('-B clean release:clean release:prepare')
			}
		}
		conditionalSteps {
			condition {
				stringsMatch('${RELEASE}', 'true', true)
			}
			steps {
				maven('release:perform')
			}
		}
    }
	wrappers {
		preBuildCleanup()		
	}
}