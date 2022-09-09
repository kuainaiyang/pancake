var Minio = require('minio')

var minioClient = new Minio.Client({
  endPoint: '127.0.0.1',
  port: 9000,
  useSSL: false,
  accessKey: 'CWr0OR6qNKmhFiLg',
  secretKey: 'nEiTxwX1jjIUNEZ0fFipGolyLj0wEXbc'
});

var file = '/Users/loki/Downloads/logo.tar.gz'

var metaData = {
  'Content-Type': 'application/octet-stream',
  'X-Amz-Meta-Testing': 1234,
  'example': 5678
}
minioClient.fPutObject('europetrip', 'logo.tar.gz', file, metaData, function(err, etag) {
  if (err) return console.log(err)
  console.log('File uploaded successfully.')
});