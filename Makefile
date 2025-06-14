.DEFAULT_GOAL=help

.PHONY: chore
chore: format ## Regular code maintenance
	git add -A
	git commit -m "chore: Regular code maintenance"
	git push origin main

.PHONY: feat
feat: format ## Introduce new features
	git add -A
	git commit -m "feat: Introduce new features"
	git push origin main

.PHONY: fix
fix: format ## Fix some bugs
	git add -A
	git commit -m "fix: Fix some bugs"
	git push origin main

.PHONY: style
style: format ## Update styling
	git add -A
	git commit -m "style: Update styling"
	git push origin main

.PHONY: refactor
refactor: format ## Refactor code
	git add -A
	git commit -m "refactor: Refactor code"
	git push origin main

.PHONY: test
test: format ## Create/Update testing
	git add -A
	git commit -m "test: Create/Update testing"
	git push origin main

.PHONY: docs
docs: format ## Create/Update documentation
	git add -A
	git commit -m "docs: Create/Update docs"
	git push origin main

.PHONY: perf
perf: format ## Performance optimization
	git add -A
	git commit -m "perf: Performance optimization"
	git push origin main

.PHONY: init
init: format ## Initial commit
	rm -rf ./.git
	git init
	git remote add origin git@github.com:njupt-sakura/langchain-demo.git
	git add -A
	git commit -m "Initial commit"
	git push -f origin main --set-upstream

.PHONY: format
format: ## Format
	mvn com.spotify.fmt:fmt-maven-plugin:format

.PHONY: exec
exec: ## Execute
	mvn org.codehaus.mojo:exec-maven-plugin:exec # mvn exec:exec

.PHONY: help
help:
	@grep -E '^[a-zA-Z0-9_-]+:.*?## .*$$' $(MAKEFILE_LIST) | \
	cut -d ":" -f1- | \
	awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'
