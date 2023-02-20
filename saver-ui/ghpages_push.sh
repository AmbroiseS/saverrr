#!/bin/sh
set -e


ng build --output-path='docs' --base-href='' --optimization=true --c=production

rm -rf ../docs
mv docs ../docs
cp ../docs/index.html ../docs/404.html

git reset
git add ../docs/

git commit -m "[UI] Deploy to github pages"

git push
