<iframe src="https://ghbtns.com/github-btn.html?user=nholuongut&repo=aws-cf-templates&type=star&count=true&size=large" frameborder="0" scrolling="0" width="160px" height="30px"></iframe>

> **New**: Manage Free Templates for AWS CloudFormation with the [nholuongut CLI](./cli/)

# Migrate from v7 to v8

## ecs/cluster

1. Amazon Linux (ECS optimized) is updated to Amazon Linux 2 (ECS optimized).
2. `SystemsManagerAccess` will be enabled by default.

## Deprecation warnings

* `operations/backup-dynamodb` will be removed in the next version (v9). Use `operations/backup-dynamodb-native` instead.
