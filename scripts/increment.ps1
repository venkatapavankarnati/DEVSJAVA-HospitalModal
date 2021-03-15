param(
    $baseVersion
)

function inc() {
    $temp = $baseVersion -split '\.'
    $patch = [convert]::ToInt32($temp[2], 10)
    $patchInc = $patch + 1
    $versionInc = $temp[0] + '.' + $temp[1] + '.' + $patchInc.ToString()
    Write-Output $versionInc
}

inc