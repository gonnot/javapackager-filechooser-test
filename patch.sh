#!/bin/zsh
set -e

export CFLAGS="-mmacosx-version-min=10.10"
cd target/SampleAPP/SampleAPP.app/Contents/MacOS/ \
  && shc -r -f universalJavaApplicationStub \
  && rm universalJavaApplicationStub && rm universalJavaApplicationStub.x.c && mv universalJavaApplicationStub.x universalJavaApplicationStub \
  && cd -
sed -i '' 's/BNDL/APPL/' target/SampleAPP/SampleAPP.app/Contents/Info.plist
