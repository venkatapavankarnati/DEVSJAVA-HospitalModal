$ErrorActionPreference = 'Stop';
$toolsDir = "$(Split-Path -parent $MyInvocation.MyCommand.Definition)" 
$fileLocation = Join-Path $toolsDir 'test.zip'
$dest = 'C:\Users\pavan\Documents\efc'
$packageArgs = @{
  packageName  = $env:ChocolateyPackageName
  Destination  = $dest
  FileFullPath = $fileLocation
}
Get-ChocolateyUnzip @packageArgs