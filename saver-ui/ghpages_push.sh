#!/bin/sh
set -e


ng build --output-path docs --base-href /saver-ui/ --optimization=true --c=production

rm -rf ../docs
mv docs ../docs

gir reset
git add ../docs/

git commit -m "[UI] Deploy to github pages"

git push
